import { get } from 'mongoose';
import {
    addNewPlayer, 
    getPlayers, 
    getPlayersWithId,
    updatePlayer,
    deletePlayer
} from '../controllers/playerControllers';

const routes = (app) => {
    app.route('/players')
    // GET endpoint
        .get(getPlayers)

    // POST endpoint
        .post(addNewPlayer);

    app.route('/players/:PlayerId')
        // GET specific player
        .get(getPlayersWithId)

        // update specific player
        .put(updatePlayer)

        // delete specific player
        .delete(deletePlayer);
}

export default routes;