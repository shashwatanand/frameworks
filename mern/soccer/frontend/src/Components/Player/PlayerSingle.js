import React from 'react';

const PlayerSingle = (props) => {
    return (
        <div className="row">
            <div className="col s12">
                <div className="card">
                    <div className="card-image">
                        <img src="soccer.jpeg" alt='soccer player' />
                        <span className="card-title">{props.player.firstName} {props.player.lastName}</span>
                    </div>
                </div>
                <div className="card-content">
                    <p>Mobile: {props.player.mobile} - Email: {props.player.email}</p>
                    <p>Strength: {props.player.strength} - Speed: {props.player.speed}</p>
                </div>
                <div className="card-action">
                    Team: {props.player.team}
                </div>
            </div>
        </div>
    );
}
 
export default PlayerSingle;