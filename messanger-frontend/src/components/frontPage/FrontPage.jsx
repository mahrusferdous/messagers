import React from "react";
import "./FrontPage.style.css";
import Login from "../login/Login";
import SignUp from "../signUp/SignUp";
import { OverlayTrigger, Button } from "react-bootstrap";

function FrontPage() {
    return (
        <div className="frontPage">
            <div className="frontPage-container">
                <OverlayTrigger trigger="click" placement="right" overlay={Login}>
                    <Button className="buttons btn btn-primary" variant="success">
                        Login
                    </Button>
                </OverlayTrigger>
                <OverlayTrigger trigger="click" placement="right" overlay={SignUp}>
                    <Button className="buttons btn btn-primary" variant="success">
                        Sign Up
                    </Button>
                </OverlayTrigger>
            </div>
        </div>
    );
}

export default FrontPage;
