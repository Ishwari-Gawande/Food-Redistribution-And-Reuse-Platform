
import { Routes, Route } from "react-router-dom";
import LandingPage from "./Pages/Landing/LandingPage";
import Login from "./Component/Login";
import AdminDashboard from "./Pages/admin/AdminDashboard";
import Users from "./Pages/admin/Users";
import PendingUsers from "./Pages/admin/PendingUsers";
import AdminMatchingQueuePage from "./Pages/admin/AdminMatchingQueuePage";
import AdminDonationsPage from "./Pages/admin/AdminDonationsPage";
import AdminDeliveriesPage from "./Pages/admin/AdminDeliveriesPage";
import AdminReportsPage from "./Pages/admin/AdminReportsPage";
import DonationMap from "./Pages/admin/DonationMap";
import DonorDashboard from "./Pages/donor/DonorDashboard";
import ReceiverDashboard from "./Pages/ReceiverDashboard";
import VolunteerDashboard from "./Pages/VolunteerDashboard";
import ForgotPassword from "./Pages/ForgotPassword";
import Register from "./Component/Register";
import CreateDonation from "./Pages/donor/CreateDonation";
import DonationSubmitted from "./Pages/donor/DonationSubmitted";
import DonationHistory from "./Pages/donor/DonationHistory";
import DonationDetails from "./Pages/donor/DonationDetails";
import ImpactDashboard from "./Pages/donor/ImpactDashboard";
import Payment from "./Pages/Industry/Payment";
import IndustryDashboard from "./Pages/Industry/IndustryDashboard";
import RequestDetails from "./Pages/Industry/RequestDetails";
import IndustryProfile from "./Pages/Industry/Profile";
import IndustryChangePassword from "./Pages/Industry/ChangePassword";
import IndustryNotifications from "./Pages/Industry/Notifications";
import IndustryRequestHistory from "./Pages/Industry/RequestHistory";

// Chatbot import
import Chatbot from "./Component/Chatbot/Chatbot";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/login" element={<Login />} />

        {/* Admin Routes */}
        <Route path="/admin" element={<AdminDashboard />} />
        <Route path="/admin/users" element={<Users />} />
        <Route path="/admin/pending-users" element={<PendingUsers />} />
        <Route path="/admin/pending-requests" element={<AdminDashboard />} />
        <Route path="/admin/matching-queue" element={<AdminMatchingQueuePage />} />
        <Route path="/admin/donations" element={<AdminDonationsPage />} />
        <Route path="/admin/deliveries" element={<AdminDeliveriesPage />} />
        <Route path="/admin/reports" element={<AdminReportsPage />} />
        <Route path="/admin/map" element={<DonationMap />} />

        {/* User Dashboard Routes */}
        <Route path="/donor" element={<DonorDashboard />} />
        <Route path="/receiver" element={<ReceiverDashboard />} />
        <Route path="/volunteer" element={<VolunteerDashboard />} />

        {/* Authentication Routes */}
        <Route path="/forgot-password" element={<ForgotPassword />} />
        <Route path="/register" element={<Register />} />

        {/* Donor Routes */}
        <Route path="/donor/create-donation" element={<CreateDonation />} />
        <Route path="/donor/donation-submitted" element={<DonationSubmitted />} />
        <Route path="/donor/history" element={<DonationHistory />} />
        <Route path="/donor/donation-details/:id" element={<DonationDetails />} />
        <Route path="/donor/impact" element={<ImpactDashboard />} />

        {/* Industry Routes */}
        <Route path="/Payment" element={<Payment />} />
        <Route path="/payment" element={<Payment />} />
        <Route path="/industry" element={<IndustryDashboard />} />
        <Route path="/industry/request/:id" element={<RequestDetails />} />
        <Route path="/industry/history" element={<IndustryRequestHistory />} />
        <Route path="/industry/notifications" element={<IndustryNotifications />} />
        <Route path="/industry/profile" element={<IndustryProfile />} />
        <Route path="/industry/change-password" element={<IndustryChangePassword />} />
      </Routes>

      {/* Beyond Ways Chatbot - Available on all pages */}
      <Chatbot />
    </>
  );
}

export default App;
