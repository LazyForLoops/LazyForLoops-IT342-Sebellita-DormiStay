import "./App.css";

export default function Login() {
    return (
        <div className="form-container">

            <h2>Welcome Back</h2>

            <form>

                <input
                    type="email"
                    placeholder="Email"
                />

                <input
                    type="password"
                    placeholder="Password"
                />

                <button>Login</button>

            </form>

        </div>
    );
}