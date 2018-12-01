# SECTION 1. Specify the base image
FROM node:alpine

# SECTION 2. Set working directory in the container before copying files etc. All futher comands will be executed relatevely to this folder
WORKDIR /usr/app

# SECTION 3. Overhead to the base image - install some dependencies etc.
# copy data from local machine to the docker image
# Important. When we make changes to the source code and rebuild the container, docker will redo all build steps
# once it meets first difference
# That's why in our example it's better to first copy package.json, then run npm install and then copy all other files (source code) 
COPY ./package.json ./
# run certain commands - install dependencies, additional software etc.
RUN npm install
COPY ./ ./

# SECTION 4. Default command (after startup)
CMD ["npm", "start"]