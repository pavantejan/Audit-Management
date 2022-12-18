export class AuthRequest {
    private username:string = "pavan";
    private password:string = "pass";

    public get Username():string{
        return this.username;
    }

    public set Username(uname:string){
        this.username=uname;
    }

    public get Password():string{
        return this.password;
    }

    public set Password(password:string){
        this.password=password;
    }
}
