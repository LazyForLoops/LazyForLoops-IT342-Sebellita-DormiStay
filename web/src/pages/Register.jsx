import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";
import "../App.css";

export default function Register() {
    const [form, setForm] = useState({ fullname: "", email: "", password: "", confirmPassword: "" });
    const [message, setMessage] = useState("");
    const navigate = useNavigate();

    const handleChange = (event) => {
        setForm({ ...form, [event.target.name]: event.target.value });
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        setMessage("");

        if (form.password !== form.confirmPassword) {
            setMessage("Passwords do not match.");
            return;
        }

        try {
            await api.post("/users", {
                fullname: form.fullname,
                email: form.email,
                password: form.password,
                role: "RESIDENT",
                status: "ACTIVE"
            });

            setMessage("Account created successfully. Redirecting to login...");
            setTimeout(() => navigate("/login"), 1000);
        } catch (error) {
            setMessage(error.response?.data?.message || "Registration failed.");
        }
    };

    return (
        <div className="form-container">
            <h2>Create Account</h2>

            <form onSubmit={handleSubmit}>
                <input name="fullname" type="text" placeholder="Full Name" value={form.fullname} onChange={handleChange} required />
                <input name="email" type="email" placeholder="Email" value={form.email} onChange={handleChange} required />
                <input name="password" type="password" placeholder="Password" value={form.password} onChange={handleChange} required />
                <input name="confirmPassword" type="password" placeholder="Confirm Password" value={form.confirmPassword} onChange={handleChange} required />

                <button type="submit">Create Account</button>
            </form>

            {message ? <p className="form-message">{message}</p> : null}
        </div>
    );
}