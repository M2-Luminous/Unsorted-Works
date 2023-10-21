import cv2 as cv
import numpy as np
import os

def rescaleFrame(frame, scale):
    width = int(frame.shape[1] * scale)
    height = int(frame.shape[0] * scale)
    dimensions = (width, height)
    return cv.resize(frame, dimensions, interpolation=cv.INTER_AREA)

def filter_table_contours(contours, min_area_threshold):
    filtered_contours = []
    for contour in contours:
        area = cv.contourArea(contour)
        if area > min_area_threshold:
            filtered_contours.append(contour)
    return filtered_contours

if __name__ == '__main__':
    # Directory containing the images
    img_dir = "C:/Users/M2-Winterfell/Documents/Code/Unsorted-Works/Visiontest/tables"

    # Get list of all images in the directory
    img_files = [f for f in os.listdir(img_dir) if f.startswith('Table') and f.endswith('.jpg')]
    img_files.sort()  # Ensure the images are in order

    for img_file in img_files:
        img_path = os.path.join(img_dir, img_file)

        # Read in an image
        img = cv.imread(img_path)

        # Check if image is loaded correctly
        if img is None:
            print(f"Error: Image {img_file} not loaded!")
            continue

        # Resize the image
        img = rescaleFrame(img, 0.25)

        # Convert to grayscale
        gray = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

        # Apply Gaussian blur to reduce noise
        blurred = cv.GaussianBlur(gray, (5, 5), 0)

        # Use Canny edge detection to detect edges
        edges = cv.Canny(blurred, threshold1=30, threshold2=100)

        # Convert to HSV color space
        hsv = cv.cvtColor(img, cv.COLOR_BGR2HSV)

        # Define lower and upper bounds for white color (adjust these values as needed)
        lower_white = np.array([0, 0, 200])
        upper_white = np.array([255, 30, 255])

        # Create a mask for the white color
        mask = cv.inRange(hsv, lower_white, upper_white)

        # Combine the edge image with the mask
        combined = cv.bitwise_or(edges, mask)

        # Find contours in the combined image
        contours, _ = cv.findContours(combined, cv.RETR_EXTERNAL, cv.CHAIN_APPROX_SIMPLE)

        # Filter the contours based on area
        min_area_threshold = 500  # Adjust this threshold as needed
        filtered_contours = filter_table_contours(contours, min_area_threshold)

        # Draw the filtered contours on the original image
        cv.drawContours(img, filtered_contours, -1, (0, 255, 0), 2)

        cv.imshow('Table', img)

        # Wait for a key press
        key = cv.waitKey(0)

        # If 'q' is pressed, exit the loop
        if key == ord('q'):
            break

    cv.destroyAllWindows()
