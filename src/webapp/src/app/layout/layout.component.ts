import { Component } from '@angular/core';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent {
  isCollapsed = false;
  navitationSubmenus: NavitationSubmenu[] = [
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
    }
  ];
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
