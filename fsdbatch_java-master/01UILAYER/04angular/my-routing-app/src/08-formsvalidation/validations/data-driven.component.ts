import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Http } from '@angular/http';

@Component({
    selector: 'data-driven',
    templateUrl: 'data-driven.component.html'
})
export class DataDrivenComponent implements OnInit {

    myForm: FormGroup

    genders: Array<string> = ['Male', 'Female']

    constructor(private http: Http) { }



    ngOnInit() {

        this.myForm = new FormGroup({
            'userData': new FormGroup({
                'username': new FormControl('', [Validators.required, this.exampleValidator], [this.asyncValidator, this.uniqueUserValidator.bind(this)] ),
                'email': new FormControl('', Validators.email)
            }),
            'password': new FormControl('', Validators.pattern("^[a-zA-Z0-9!@#$%^&*]{6,16}$")),
            'age': new FormControl('', [Validators.min(18), Validators.max(100)]),
            'gender': new FormControl('Male')
        })

        this.myForm.statusChanges.subscribe((data: any) => console.log(data));

    }

    onSubmit() {
        console.log(this.myForm);
        console.log(this.myForm.value);
    }

    asyncValidator(control: FormControl): Promise<{ [s: string]: boolean }> {
        // Server to make a request, AJAX -> can take time
        const promise = new Promise<{ [s: string]: boolean }>(
            (resolve, reject) => {
                setTimeout(() => {
                    console.log('Validation is fired now!!')
                    if (control.value === 'Puneet') {
                        resolve({ "invalid": true })
                    }
                    else {
                        resolve(null);
                    }
                }
                    , 2000)

            })
        return promise;
    }
    uniqueUserValidator(control: FormControl): Promise<any> {
        // Server to make a request, AJAX -> can take time

        const promise = new Promise<{ [s: string]: boolean }>(
            (resolve, reject) => {

                if (control.value && control.value!='') {

                    setTimeout(() => {
                        console.log('Validation is fired now!!')
                        this.http.get('http://localhost:7000/userexists/' + control.value)
                            .toPromise().then((res) => res.json())
                            .then((data) => {
                                console.log(data)
                                if (data.exists === true) {
                                    resolve({ "invalid": true })
                                }
                                else {
                                    resolve(null)
                                }
                            }
                            )
                    }
                        , 1000)
                }
                else{
                    resolve(null)
                }
            })
        return promise;


    }

    exampleValidator(control: FormControl): { [s: string]: boolean } {
        if (control.value === 'Ravi') {
            return { "example": true }
        }
        return null;
    }

}

