import React from "react";
import "./App.css";
import { Fragment, useState } from "react";

import Login from "./components/login"
import TableView from "./components/table";

function App() {
  const [userID, setUserId] = useState(-1);

  return userID < 0 ? (
    <Login user={setUserId} />
  ) : (
    <Fragment>
      <TableView/>
    </Fragment>
  );
}

export default App;
