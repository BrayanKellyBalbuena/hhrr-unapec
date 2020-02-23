import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../shared/services/authentication.service';
import { CurrentUser } from '../core/models/user';
import { Role } from '../core/enums/Role.enum';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit{
  isCollapsed = false;
  navitationSubmenus: NavitationSubmenu[] = [];

  constructor(private authService: AuthenticationService) {

  }

  ngOnInit(): void {
   this.setNavigationSubmenu();
  }

  setNavigationSubmenu() {

   if (this.authService.getCurrentUser().roles.findIndex(e => e === Role.USER) === -1) {
      this.navitationSubmenus  = [
        {
          title: 'Mantenimientos',
          icon: 'setting',
          items:
          [
            { title: 'Languages', url: '/languages' },
            { title: 'Risk Levels', url: '/risk_levels'},
            { title: 'Skills', url: '/skills'},
            { title: 'Institutions', url: '/institutions'},
            { title:  'Trainings', url: '/trainings'}
          ]
        },
        {
          title: 'Jobs',
          icon: 'file-search',
          items: [
            { title: 'Post jobs', url: '/jobs' },
          ]
        }];
   } else {
     this.navitationSubmenus = [
      {
        title: 'Mantenimientos',
        icon: 'setting',
        items:
        [
          { title: 'My skills', url: '/candidate-skills' },
          { title: 'My languages', url: '/candidate-languages' },
          { title: 'My trainings', url: '/candidate-trainings'}
        ]
      },
      {
        title: 'Jobs',
        icon: 'file-search',
        items: [
          { title: 'Search Jobs', url: '/candidate-jobs-seach' },
          { title: 'Jobs applied', url: '/candidate-applied-jobs' },
        ]
      }
     ];
   }
  }

  logout() {
    this.authService.logout();
  }

}

export interface NavitationSubmenu {
  title: string;
  icon: string;
  items: NavigationItem[] | null;
}

export interface NavigationItem {
  title: string;
  url: string;
}

