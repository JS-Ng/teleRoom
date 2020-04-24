import React from 'react';
import logo from './logo.svg';
import './App.css';
import ReactPlayer from 'react-player'
function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" />  */}
        <div className="Video">
          <ReactPlayer url="https://youtu.be/RTvk9KmLcms" controls="true" playing ></ReactPlayer>
        </div>       
      </header>
    </div>
  );
}

export default App;
