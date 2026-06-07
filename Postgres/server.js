const express = require('express');
const cors = require('cors');
const pool = require('./db');

const app = express();

app.use(cors());
app.use(express.json());
app.use(express.static('public'));

// CREATE
app.post('/employees', async (req, res) => {
    const { name, email, salary } = req.body;

    await pool.query(
        'INSERT INTO employee(name,email,salary) VALUES($1,$2,$3)',
        [name, email, salary]
    );

    res.send("Employee Added");
});

// READ
app.get('/employees', async (req, res) => {
    const result = await pool.query(
        'SELECT * FROM employee ORDER BY id'
    );

    res.json(result.rows);
});

// UPDATE
app.put('/employees/:id', async (req, res) => {
    const { name, email, salary } = req.body;

    await pool.query(
        'UPDATE employee SET name=$1,email=$2,salary=$3 WHERE id=$4',
        [name, email, salary, req.params.id]
    );

    res.send("Employee Updated");
});

// DELETE
app.delete('/employees/:id', async (req, res) => {

    await pool.query(
        'DELETE FROM employee WHERE id=$1',
        [req.params.id]
    );

    res.send("Employee Deleted");
});

app.listen(3000, () => {
    console.log("Server running on port 3000");
});