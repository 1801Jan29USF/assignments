export class User {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    roleId: number;
    role: string;

    constructor(id: number = 0, username: string = '', password: string = '', firstName: string = '', lastName: string = '',
        email: string = '', roleId: number = 0, role: string = '') {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleId = roleId;
        this.role = role;
    }
}
