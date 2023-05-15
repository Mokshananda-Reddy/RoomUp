import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Sidebarbash from "../sidebardash/Sidebardash";
import '@testing-library/jest-dom/extend-expect';


test('renders sidebar logo', () => {
  render(<MemoryRouter><Sidebarbash /></MemoryRouter>);
  const logoElement = screen.getByAltText('Mindwise');
  expect(logoElement).toBeInTheDocument();
});

test('renders dashboard button', () => {
    render(<MemoryRouter><Sidebarbash /></MemoryRouter>);
    const dashtext = screen.getByText('Dashboard');
    expect(dashtext).toBeInTheDocument();
});

test('renders block managers button', () => {
    render(<MemoryRouter><Sidebarbash /></MemoryRouter>);
    const dashtext = screen.getByText('Block Managers');
    expect(dashtext).toBeInTheDocument();
});

test('renders students button', () => {
    render(<MemoryRouter><Sidebarbash /></MemoryRouter>);
    const dashtext = screen.getByText('Students');
    expect(dashtext).toBeInTheDocument();
});

test('renders logout button', () => {
    render(<MemoryRouter><Sidebarbash /></MemoryRouter>);
    const dashtext = screen.getByText('Logout');
    expect(dashtext).toBeInTheDocument();
});