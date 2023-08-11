import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
   vus: 750,         // 750 vus users
   duration: '180s', // 180 seconds (duration)
};

export default function() {
   http.get(__ENV.HOST_NAME + "/customers?personalId=12345678902");
   sleep(1);
}