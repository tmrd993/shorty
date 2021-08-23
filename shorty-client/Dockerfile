# Build stage
FROM node:latest as build-stage

WORKDIR /usr/local/app

COPY package.json ./
RUN npm install

COPY ./ /usr/local/app
RUN npm run build

# Serve stage
FROM nginx:1.21.1-alpine

COPY --from=build-stage /usr/local/app/dist/shorty-client /usr/share/nginx/html

EXPOSE 80