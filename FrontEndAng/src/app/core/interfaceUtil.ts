import {Register} from '../register/register';
import {Login} from '../login/login';
import {City} from '../home-page/city';
import {Address} from '../register/address';

export class InterfaceUtil {
  static getEmptyRegister(): Register {
    return {
      firstName: '',
      surname: '',
      password: '',
      confirmedPassword: '',
      address: this.getEmptyAddress()
    };
  }

  static getEmptyLogin(): Login {
    return {
      email: '',
      password: ''
    };
  }

  static getEmptyCity(): City {
    return {
      city: ''
    };
  }

  static getEmptyAddress(): Address {
    return {
      country: '',
      county: '',
      city: '',
      streetAddress: '',
      postalCode: '',
      phoneNumber: '',
      emailAddress: '',
    };
  }
}

