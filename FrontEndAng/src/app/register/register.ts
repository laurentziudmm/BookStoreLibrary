import { Address } from './address';

export interface Register {
  firstName: string;
  surname: string;
  password: string;
  confirmedPassword: string;
  address: Address;
}

