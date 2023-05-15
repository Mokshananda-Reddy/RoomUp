import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Notfound from "../../pages/notfound/Notfound"
import '@testing-library/jest-dom/extend-expect';

test('renders Image for Not found page', () => {
    render(<MemoryRouter><Notfound /></MemoryRouter>);
    const img = screen.getByAltText('Notfound');
    expect(img).toBeInTheDocument();
  });

test('renders Title for Not found page', () => {
  render(<MemoryRouter><Notfound /></MemoryRouter>);
  const title = screen.getByText((content) => {
    return content.includes('Page Not Found');
  });
  expect(title).toBeInTheDocument();
});

test('renders go back button for Not found page', () => {
    render(<MemoryRouter><Notfound /></MemoryRouter>);
    const goback = screen.getByText((content) => {
      return content.includes('Go Back');
    });
    expect(goback).toBeInTheDocument();
});