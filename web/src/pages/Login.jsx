import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios";
import "../App.css";

export default function Login() {
    const [form, setForm] = useState({ email: "", password: "" });
    const [message, setMessage] = useState("");
    const navigate = useNavigate();

    const handleChange = (event) => {
        setForm({ ...form, [event.target.name]: event.target.value });
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        setMessage("");

        try {
            const response = await api.post("/users/login", {
                email: form.email,
                password: form.password
            });

            if (response.data?.email) {
                navigate("/dashboard");
            }
        } catch (error) {
            setMessage(error.response?.data?.message || "Login failed.");
        }
    };

    return (
        <div className="form-container">
            <h2>Welcome Back</h2>

            <form onSubmit={handleSubmit}>
                <input name="email" type="email" placeholder="Email" value={form.email} onChange={handleChange} required />
                <input name="password" type="password" placeholder="Password" value={form.password} onChange={handleChange} required />

                <button type="submit">Login</button>
            </form>

            {message ? <p className="form-message">{message}</p> : null}
        </div>
    );
}