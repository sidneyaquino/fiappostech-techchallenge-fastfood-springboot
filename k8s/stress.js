import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
   vus: 750,            //750 vus usuarios
   duration: '180s',    //180 duration segundos de duração
};

export default function() {
   http.get("http://localhost:8080/customers?personalId=12345678902");
   sleep(1);
}