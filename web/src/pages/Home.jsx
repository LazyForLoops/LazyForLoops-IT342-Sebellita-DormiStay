import { Link } from "react-router-dom";
import "../App.css";

export default function Home() {
    return (
        <div className="container">
            <div className="hero">
                <h1>DormiStay</h1>
                <p>
                    A Dormitory Management System designed to simplify resident
                    management, room assignments, and administrative tasks.
                </p>

                <div className="buttons">
                    <Link to="/login">
                        <button>Login</button>
                    </Link>

                    <Link to="/register">
                        <button className="secondary">Register</button>
                    </Link>
                </div>
            </div>
        </div>
    );
}