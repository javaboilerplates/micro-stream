echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker push javaboilerplates/micro-stream
docker push javaboilerplates/micro-stream:0.0.0
