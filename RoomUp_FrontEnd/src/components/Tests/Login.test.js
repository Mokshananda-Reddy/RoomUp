import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Login from "../../pages/login/Login"
import '@testing-library/jest-dom/extend-expect';


test('renders Title for login page', () => {
  render(<MemoryRouter><Login /></MemoryRouter>);
  const title = screen.getByText((content) => {
    return content.includes('RoomUp');
  });
  expect(title).toBeInTheDocument();
});

test('renders login button for login page', () => {
    render(<MemoryRouter><Login /></MemoryRouter>);
    const login = screen.getByText((content) => {
      return content.includes('Login');
    });
    expect(login).toBeInTheDocument();
});
