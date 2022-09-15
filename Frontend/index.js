import React from 'react'; //리액트의 사용을 위해 import
import ReactDOM from 'react-dom/client'; //리액트 DOM의 사용을 위해
import './index.css'; //css import
import AppRouter from './AppRouter'; //APP컴포넌트 import
import reportWebVitals from "./reportWebVitals";

//React 버전 update로 인하여 더이상 ReactDOM.render가 사용되지 않고
//root.render로 변경됨
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <AppRouter />
  </React.StrictMode>
);

reportWebVitals();
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals

