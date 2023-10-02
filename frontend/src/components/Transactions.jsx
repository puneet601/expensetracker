import React, { useEffect, useState } from "react";
import axios from "axios";

export default function Transactions() {
  const [transactions, setTransactions] = useState([]);

  useEffect(() => {
    getTransactions();
  }, []);

  async function getTransactions() {
    try {
      const response = await axios.get(
        "http://localhost:8080/trackmyfinance/transaction/getAllForUser/1"
      );
      setTransactions(response.data);
    } catch (error) {
      console.error("Error fetching transactions:", error);
    }
  }

  return (
    <div>
      <h1>Transactions</h1>
      {transactions.map((t) => `${t.description}`)}
    </div>
  );
}
