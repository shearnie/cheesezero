import './App.css';
import Navbar from "./components/Navbar";
import Home from "./pages/home.js";
import Browse from "./pages/browse.js";
import ByType from "./pages/by-type.js";
import Search from "./pages/search.js";
import View from "./pages/view.js";
import {
    BrowserRouter as Router,
    Routes,
    Route,
} from "react-router-dom";

function App() {
  return (
    <Router>
      <Navbar />
      <div className="container">
          <Routes>
              <Route exact path="/" element={<Home />} />
              <Route path="/browse" element={<Browse />} />
              <Route path="/by-type/:cheesetype" element={<ByType />} />
              <Route path="/by-type" element={<ByType />} />
              <Route path="/search" element={<Search />} />
              <Route path="/view" element={<View />} />
          </Routes>
      </div>
    </Router>
  );
}

export default App;
