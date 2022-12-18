export class AuthResponse {
    private name:string = "";
    private projectName:string = "";
    private isValid:boolean = false;

    public get Name():string{
        return this.name;
    }

    public get ProjectName():string{
        return this.projectName;
    }

    public get IsValid():boolean{
        return this.isValid;
    }

    public set Name(name:string){
        this.name=name;
    }

    public set ProjectName(pname:string){
        this.projectName=pname;
    }

    public set IsValid(value:boolean){
        this.isValid = value;
    }

}
