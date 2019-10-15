/*
 * Copyright Dansk Bibliotekscenter a/s. Licensed under GNU GPL v3
 * See license text at https://opensource.dbc.dk/licenses/gpl-3.0
 */

import React from "react";

const request = require('superagent');

class PayaraReactGUI extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            instance: ''
        };

        this.getInstance = this.getInstance.bind(this);
    }

    componentDidMount() {
        if (this.state.instance === '') {
            this.getInstance();
        }
    }

    getInstance() {
        request
            .get('/api/v1/config')
            .set('Content-Type', 'text/plain')
            .then(res => {
                const instance = res.text;
                this.setState({
                    instance: instance
                });
                document.title = "Payara React Example (" + instance + ")";
            })
            .catch(err => {
                alert(err.message);
            });
    }

    render() {
        return (
            <div>
                <p>Payara React Example ({this.state.instance})</p>
            </div>
        )
    }

}

export default PayaraReactGUI;