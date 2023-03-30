import csv

with open('old_data.csv', 'r') as oldfile:
    oldreader = csv.reader(oldfile)
    headers = next(oldreader)  

    
    year_index = headers.index('Year')
    make_index = headers.index('Make')
    model_index = headers.index('Model')

    # Open a new CSV file for writing the extracted data
    with open('new_data.csv', 'w', newline='') as newfile:
        newwriter = csv.writer(newfile)
        newwriter.writerow(['Year', 'Make', 'Model'])  

        
        for row in oldreader:
            year = row[year_index]
            make = row[make_index]
            model = row[model_index]
            newwriter.writerow([year, make, model])  

print("Data written to new_data.csv")
