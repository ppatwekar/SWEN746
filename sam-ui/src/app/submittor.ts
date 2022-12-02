import AbstractUser from "./AbstractUser";

export default interface Submittor extends AbstractUser{
    name: string,
    papersSubmitted: number[]
}