#!make

all: build

build:
	docker build -t dina/morph-service:v0.2.1 .


# docker login
release:
	docker push dina/morph-service:v0.2.1

