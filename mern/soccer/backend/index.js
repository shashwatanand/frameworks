import express from 'express';
import mongoose from 'mongoose';
import bodyParser from 'body-parser';

const app = express();
const PORT = 3001;

// mongo connection
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost:27017/soccerDB', {
    useNewUrlParser: true,
    useUnifiedTopology: true 
});

// bodyparser setup
app.use(bodyParser.urlencoded({ extended: true}));
app.use(bodyParser.json());


app.get('/', (req, res) => 
    res.send(`Our soccer application is running on PORT ${PORT}`)
);

app.listen(PORT, () => 
    console.log(`Your soccer server is running on PORT ${PORT}`)
);