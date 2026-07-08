import "./App.css";

export default function Register() {
    return (
        <div className="form-container">
            <h2>Create Account</h2>

            <form>

                <input
                    type="text"
                    placeholder="Full Name"
                />

                <input
                    type="email"
                    placeholder="Email"
                />

                <input
                    type="password"
                    placeholder="Password"
                />

                <input
                    type="password"
                    placeholder="Confirm Password"
                />

                <button>Create Account</button>

            </form>
        </div>
    );
}