FROM node:20 AS builder

WORKDIR /app

COPY package*.json ./
COPY angular.json ./
COPY tsconfig*.json ./
COPY . .

RUN npm install
RUN npm run build -- --configuration production

FROM nginx:alpine

RUN rm /etc/nginx/conf.d/default.conf

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=builder /app/dist/frontend/browser /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
