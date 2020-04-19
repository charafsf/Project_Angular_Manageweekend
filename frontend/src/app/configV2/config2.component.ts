import {Component, OnInit} from '@angular/core';

/**
 * @title Nested menu
 */
@Component ({
  selector : ' app-configV2 ',
  templateUrl : 'config2.component.html',
  styleUrls : ['config2.component.scss']
})
export class ConfigV2Component implements OnInit {

  public name = localStorage.getItem('name') ;

  ngOnInit() { }
}