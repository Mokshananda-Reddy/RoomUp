import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Tasinfo from "../../components/tasinfo/Tasinfo";
import '@testing-library/jest-dom/extend-expect';


test('renders service id info', () => {
  render(<MemoryRouter><Tasinfo /></MemoryRouter>);
  const servid = screen.getByText((content) => {
    return content.includes('ServiceID');
  });
  expect(servid).toBeInTheDocument();
});

test('renders service type info', () => {
    render(<MemoryRouter><Tasinfo /></MemoryRouter>);
    const servtype = screen.getByText((content) => {
      return content.includes('Service Type');
    });
    expect(servtype).toBeInTheDocument();
});

test('renders date info', () => {
    render(<MemoryRouter><Tasinfo /></MemoryRouter>);
    const servdate = screen.getByText((content) => {
      return content.includes('Date');
    });
    expect(servdate).toBeInTheDocument();
});

test('renders room info', () => {
    render(<MemoryRouter><Tasinfo /></MemoryRouter>);
    const servroom = screen.getByText((content) => {
      return content.includes('Room Number');
    });
    expect(servroom).toBeInTheDocument();
});

test('renders feedback info', () => {
    render(<MemoryRouter><Tasinfo /></MemoryRouter>);
    const servfeed = screen.getByText((content) => {
      return content.includes('Feedback');
    });
    expect(servfeed).toBeInTheDocument();
});

test('renders special requests info', () => {
    render(<MemoryRouter><Tasinfo /></MemoryRouter>);
    const servSR = screen.getByText((content) => {
      return content.includes('Special Requests');
    });
    expect(servSR).toBeInTheDocument();
});

test('renders go back info', () => {
    render(<MemoryRouter><Tasinfo /></MemoryRouter>);
    const goback = screen.getByText('Go Back');
    expect(goback).toBeInTheDocument();
});