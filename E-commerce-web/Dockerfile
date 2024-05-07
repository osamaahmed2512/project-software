# FROM node:16-alpine as build

# WORKDIR /app

# COPY . .

# RUN npm install
# RUN npm run build 

# FROM nginx:alpine

# COPY --from=build /app/dist/e-commerce-web /usr/share/nginx/html

# EXPOSE 80

# CMD ["nginx", "-g", "daemon off;"]


# Use the official Node.js image as the base image
FROM node:18.13 as build

# Set the working directory inside the container
WORKDIR /project

RUN npm install -g @angular/cli@17.3.6


# Copy the package.json and package-lock.json files into the container
COPY package*.json ./

# Install dependencies
RUN npm i
COPY . .
# Copy the rest of the application's source code into the container


EXPOSE 4200

CMD ["npm", "start"]


# # Build the Angular application
# RUN npm run build --prod

# # Stage 2: Use a smaller base image for the production build
# FROM nginx:alpine

# # Copy the built Angular app from the previous stage into the nginx image
# COPY --from=build /app/dist/* /usr/share/nginx/html

# # Expose port 80
# EXPOSE 80

# # Start nginx to serve the Angular app
# CMD ["nginx", "-g", "daemon off;"]
