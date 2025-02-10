import { useEffect, useState } from "react";
import "./App.css";

async function deleteCustomer(id: string) {
  await fetch(`http://localhost:8080/customers/${id}`, { method: "DELETE" });
}

function App() {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    async function fetchCustomers() {
      const raw = await fetch("http://localhost:8080/customers");

      setCustomers(await raw.json());
    }
    fetchCustomers();
  }, []);

  return (
    <>
      <h1>Demo Crud</h1>
      <form className="form">
        <label>First Name </label>
        <input></input>
        <label>Last Name </label>
        <input></input>
        <button type="submit">Submit</button>
      </form>
      <ul>
        {customers.map(
          (customer: { id: string; firstName: string; lastName: string }) => (
            <li key={customer.id} className="list-item">
              {customer.firstName} {customer.lastName}
              <button onClick={() => deleteCustomer(customer.id)}>X</button>
            </li>
          )
        )}
      </ul>
    </>
  );
}

export default App;
