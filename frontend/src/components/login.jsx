import React, { useState } from "react";
import axios from "axios";

function Login({ user }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const urlBase = "http://localhost:8080/miniproject-1.0-SNAPSHOT/api";

  const startLogin = (credentials) => {
    console.log(credentials)
    axios
      .post(`${urlBase}/faculty/login`, credentials)
      .then((json) => {
        const uid=isNaN(parseInt(json.data))?-1:parseInt(json.data);

        user(uid);
        
        console.log(parseInt(json.data))
        localStorage.setItem("Id", json.data);
        setEmail("");
        setPassword("");
        if(json.status===200)
        alert("Correct credentials");
        else
        alert("Invalid Credentials");

      })
      .catch(() => {
        alert("Invalid Credentials");
      });
  };

  const handleLogin = (event) => {
    event.preventDefault();

    const credentials = {
      email,
      password,
    };
    startLogin(credentials);
  };

  return (
    <div className="Auth-form-container">
      <form className="Auth-form">
        <div className="Auth-form-content">
          <h3 className="Auth-form-title">Sign In</h3>
          <div className="form-group mt-3">
            <label>Email address</label>
            <input
              type="email"
              required
              className="form-control mt-1"
              placeholder="Enter email"
              value={email}
              onChange={(event) => setEmail(event.target.value)} 
            />
          </div>
          <div className="form-group mt-3">
            <label>Password</label>
            <input
              type="password"
              className="form-control mt-1"
              placeholder="Enter password"
              value={password}
              required
              onChange={(event) => setPassword(event.target.value)}
            />
          </div>
          <div className="d-grid mt-5">
            <button
              type="submit"
              className="btn btn-primary"
              onClick={(e) => handleLogin(e)}
            >
              Submit
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}
export default Login;
