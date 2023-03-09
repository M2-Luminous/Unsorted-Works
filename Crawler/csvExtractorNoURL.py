import csv

def crawler(csv_file):
    max_rating = 0
    with open(csv_file, 'r') as f:
        reader = csv.reader(f)
        next(reader) # skip the header row
        for row in reader:
            car_brand = row[0]
            author = row[1]
            text = row[2]
            rating = float(row[3])
            
            if 'fantastic' in text:
                print(f'The text contains "fantastic" ')
                
            max_rating = max(max_rating, rating)
            min_rating = min(min_rating, rating)
            sum_rating = sum(sum_rating, rating)

    print(f'The maximum rating is {max_rating}')

if __name__ == '__main__':
    csv_file = 'car_data.csv'
    crawler(csv_file)