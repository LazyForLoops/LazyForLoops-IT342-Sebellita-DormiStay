import "../App.css";

export default function Dashboard() {

    return (

        <div className="dashboard">

            <aside className="sidebar">

                <h2>DormiStay</h2>

                <ul>
                    <li>Dashboard</li>
                    <li>Residents</li>
                    <li>Rooms</li>
                    <li>Payments</li>
                    <li>Maintenance</li>
                    <li>Reports</li>
                    <li>Profile</li>
                    <li>Logout</li>
                </ul>

            </aside>

            <main className="content">

                <h1>Dashboard</h1>

                <div className="cards">

                    <div className="card">
                        <h3>Total Residents</h3>
                        <p>120</p>
                    </div>

                    <div className="card">
                        <h3>Occupied Rooms</h3>
                        <p>42</p>
                    </div>

                    <div className="card">
                        <h3>Available Rooms</h3>
                        <p>18</p>
                    </div>

                    <div className="card">
                        <h3>Pending Payments</h3>
                        <p>6</p>
                    </div>

                </div>

            </main>

        </div>

    );
}