# Use an existing docker image as a base
FROM alpine

# Download and install a dependency
RUN export http_proxy=http://192.168.1.10:3128/
RUN apk add --update redis

# Tell the image what to do when it starts
# as a container
CMD ["redis-server"]