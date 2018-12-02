# "builder" stage
FROM node:alpine as builder

WORKDIR '/app'
COPY package.json .
RUN npm install
COPY . .
RUN npm run build

# the output from the first step we are interested in is located in /app/build folder in the first container

# The second container is to actually run prod configuration on nginx server
FROM nginx

# copy data from builder stage
COPY --from=builder /app/build /usr/share/nginx/html