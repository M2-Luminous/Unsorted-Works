#an updated version of the code that includes the sentiment analysis 
#and a Flask server to receive requests
import requests
from bs4 import BeautifulSoup
from dateutil.parser import parse
import pandas as pd
from typing import Optional
import re
from transformers import pipeline
from flask import Flask, request, jsonify

app = Flask(__name__)


#This code uses the transformers library to perform sentiment analysis on the reviews. 
#The get_sentiment function takes a string as input and returns the sentiment label 
#('positive' or 'negative').
def get_sentiment(text: str) -> str:
    classifier = pipeline('sentiment-analysis')
    result = classifier(text)[0]
    return result['label']

def scrape_car_reviews(manufacturer: str, model: str, year: int) -> Optional[pd.DataFrame]:
    # Replace the spaces and dashes 
    model = model.replace(" ", "_")                             #.replace("-", "_")
    model = model.replace("-", "_")
    manufacturer = manufacturer.replace(" ", "_")               #.replace("-", "_")
    manufacturer = manufacturer.replace("-", "_")
    
    # Construct the URL 
    url = f"https://www.cars.com/research/{manufacturer}-{model}-{year}/consumer-reviews/?page_size=200"
    
    # Send a request to the URL and get the response
    response = requests.get(url)

    # Status Checking (Can deleted)
    if response.status_code != 200:
        print(f"Error: Request failed with status code {response.status_code}")
        return
    
    # Parser generated
    soup = BeautifulSoup(response.text, "html.parser")
    
    # Find consumer review containers
    review_containers = soup.find_all(class_="consumer-review-container")
    
    # Dictionaries to store
    review_data = []
    
    for container in review_containers:

        # Find the title of the review
        title = container.find("h3", class_="sds-heading--7").text.strip()
        
        ###########################################################################
        
        # Find the author data of the review
        author_data = container.find(class_="review-byline")
        author_data = author_data.find_all("div")

        ###########################################################################
        
        # Find date
        date = parse(author_data[0].text.strip())

        ###########################################################################

        # Find regular expression pattern and search for match string
        author_regex = re.compile(r"By (.+?)")
        author_match = author_regex.search(author_data[1].text.strip())
        author = author_match.group(1)

        ##########################################################################
        
        # Find the content of the review
        content = container.find("p").text.strip()

        ##########################################################################
        
        # Get sentiment of the review content
        sentiment = get_sentiment(content)

        # Store data into dictionary
        review_data.append({
            "Title": title,
            "Author": author,
            "Date": date,
            "Content": content,
            "Sentiment": sentiment
        })
    
    df = pd.DataFrame.from_records(review_data)
    return df


#The handle_scrape_car_reviews function is a Flask route 
#that accepts a POST request with JSON data
@app.route('/scrape_car_reviews', methods=['POST'])
def handle_scrape_car_reviews():
    data = request.get_json()
    manufacturer = data['manufacturer']
    model = data['model']
    year = data['year']
    reviews_df = scrape_car_reviews(manufacturer, model, year)
    if reviews_df is not None:
        return jsonify(reviews_df.to_dict(orient='records'))
    else:
        return jsonify({'error': 'Failed to scrape reviews'}), 500

if __name__ == '__main__':
    app.run(debug=True)




