
import { Routes, Route } from "react-router-dom";

import Login from "./Component/Login";
import AdminDashboard from "./pages/AdminDashboard";
import DonorDashboard from "./pages/DonorDashboard";
import ReceiverDashboard from "./pages/ReceiverDashboard";
import VolunteerDashboard from "./pages/VolunteerDashboard";
import ForgotPassword from "./pages/ForgotPassword";
import Register from "./Component/Register";

function App() {
  return (
    <Routes>
       <Route path="/" element={<Login />} />
       <Route path="/login" element={<Login />} />
      <Route path="/admin" element={<AdminDashboard />} />
      <Route path="/donor" element={<DonorDashboard />} />
      <Route path="/receiver" element={<ReceiverDashboard />} />
      <Route path="/volunteer" element={<VolunteerDashboard />} />
    <Route path="/forgot-password" element={<ForgotPassword />} />
<Route path="/register" element={<Register />} />
    </Routes>
  );
}

export default App;