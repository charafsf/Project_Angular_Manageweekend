import { OnInit, Component } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { MessageService } from './message.service';
import { Message } from './message.model';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})

export class MessageComponent {

  form: FormGroup;

  constructor(private messageService: MessageService) {
      this.form = new FormGroup({
        objet: new FormControl(null, {
          validators: [Validators.required, Validators.minLength(3)]
        }),
        message: new FormControl(null, {
          validators: [Validators.required, Validators.minLength(3)]
        })
      });
    }

    onSendInf() {
    if (this.form.invalid) {
      return;
    } else {
      const msg: Message = {
        objet: this.form.value.objet,
        message: this.form.value.message,
      };
      this.messageService.connecte(msg);
    }
  }
}
