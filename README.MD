# Java Demo

## Initial Bootstrap

```shell
curl -s https://gist.githubusercontent.com/willitscale/6323565922e5db45f17d0d35ea354888/raw/af03dce464e159984aee1919fee2bc683089bf07/install.sh | bash
```

## Running through Docker
```shell
docker-compose up
```

## Running Locally
```shell
docker run -p 27017:27017 mongo
./gradlew run
```