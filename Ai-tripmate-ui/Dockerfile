FROM node

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

# port 
EXPOSE 5173

CMD [ "npm", "run", "dev" ]
