FROM node:alpine as builder

WORKDIR /app
COPY .  /app/
RUN npm install @angular/cli -g
RUN npm i
RUN ng build --prod

FROM nginx:alpine
RUN rm -rf /usr/share/nginx/html/*
COPY nginx/nginx.conf /etc/nginx/nginx.conf
COPY --from=builder /app/dist/frontend /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]
