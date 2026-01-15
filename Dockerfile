# Use the official Node.js image as the base image
FROM node:16

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and install dependencies
COPY package.json .
RUN npm install

# Copy the rest of the application code
COPY . .

# Expose the port (if applicable, e.g., for a web app)
EXPOSE 3000

# Start the application
CMD ["node", "index.js"]
