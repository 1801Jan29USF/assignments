export class Resrequest {
    username: string;
    password: string;
    id: number;
    newStatus: String;
    constructor(username: string = '', password: string = '', id: number = 0,
        newStatus: String = '') {
        this.username = username;
        this.password = password;
        this.id = id;
        this.newStatus = newStatus;
    }
}
